package com.bilolbek.mycodingpractices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;



@Controller
public class IndexController {



    @Autowired
    private GuessNumberRepository guessNumberRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/index.html")
    public String indexInMenu(){
        return "index";
    }

    @GetMapping("/guessNumber.html")
    public String guessNumber(Model model){

        //read the last 5 tries and show them
        UserGuessNumber getUserGuessNumber;
        int j = 1;
        if(guessNumberRepository.count()<6) {
            for (long i = 1; i <= guessNumberRepository.count(); i++) {
                getUserGuessNumber = guessNumberRepository.findById(j)
                        .orElseThrow(() -> new ResourceNotFoundException("Row does not exist with id: "));

                model.addAttribute("guessId" + j, getUserGuessNumber.getId());
                model.addAttribute("firstGuess" + j, getUserGuessNumber.getFirstGuess());
                model.addAttribute("secondGuess" + j, getUserGuessNumber.getSecondGuess());
                model.addAttribute("thirdGuess" + j, getUserGuessNumber.getThirdGuess());
                model.addAttribute("randomNumber" + j, getUserGuessNumber.getRandomNumber());
                j++;
            }
        }
        //prevents the sixth row to be called
        if(guessNumberRepository.count()>=6) {
            for (long i = 1; i < guessNumberRepository.count(); i++) {
                getUserGuessNumber = guessNumberRepository.findById(j)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: "));

                model.addAttribute("guessId" + j, getUserGuessNumber.getId());
                model.addAttribute("firstGuess" + j, getUserGuessNumber.getFirstGuess());
                model.addAttribute("secondGuess" + j, getUserGuessNumber.getSecondGuess());
                model.addAttribute("thirdGuess" + j, getUserGuessNumber.getThirdGuess());
                model.addAttribute("randomNumber" + j, getUserGuessNumber.getRandomNumber());
                j++;
            }
        }

        return "guessNumber";}

    @GetMapping("/afterNDays.html")
    public String afterNDays(){return "afterNDays";}

    @GetMapping("/palindromeNumber.html")
    public String palindromeNumber(){return "palindromeNumber";}

    @GetMapping("/LeapYear.html")
    public String LeapYear(){
        return "LeapYear";
    }

    @GetMapping("/chineseZodiac.html")
    public String chineseZodiac(){return "chineseZodiac";}

    @GetMapping("/guessBirthday.html")
    public String guessBirthday(Model model){
        GuessBirthday guessBirthday=new GuessBirthday();
        model.addAttribute("guessBirthdaySets", guessBirthday.getSet1());
        model.addAttribute("guessBirthdaySets2", guessBirthday.getSet2());
        model.addAttribute("guessBirthdaySets3", guessBirthday.getSet3());
        model.addAttribute("guessBirthdaySets4", guessBirthday.getSet4());
        model.addAttribute("guessBirthdaySets5", guessBirthday.getSet5());
        return "guessBirthday";}

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {

        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

    @PostMapping("/guessNumber.html")
    public void guessNumberReadUserInput(@ModelAttribute UserGuessNumber userGuessNumber, Model model){
        //generate a random number
        int theNumber;
        Random random=new Random();
        theNumber=random.nextInt(20);
        userGuessNumber.setRandomNumber(theNumber);

        //store the data to the database
        guessNumberRepository.save(userGuessNumber);

        //take the content of the last row, which is after the 6th, to the 6th row
        if(userGuessNumber.getId()>6){
            editGuessNumberLastRow(userGuessNumber.getId());
            deleteGuessNumber(userGuessNumber.getId());
        }
        //check the user's guessed numbers
        if (userGuessNumber.getFirstGuess()==theNumber) {
            model.addAttribute("message", "You guessed correctly, the number was " + userGuessNumber.getFirstGuess());
        }
        else if (userGuessNumber.getSecondGuess()==theNumber) {
            model.addAttribute("message", "You guessed correctly, the number was "+userGuessNumber.getSecondGuess());
        }
        else if (userGuessNumber.getThirdGuess()==theNumber) {
            model.addAttribute("message", "You guessed correctly, the number was "+userGuessNumber.getThirdGuess());
        }
        else model.addAttribute("message", "You could not guess it, the number was "+theNumber);


        //update the history table, keep the last 5 tries, remove the ones in the beginning to add the latest data
        if(guessNumberRepository.findById(6).isPresent()){
            for(int i=1;i<6;i++){
                editGuessNumberTable(i);
            }

        }
        //read the last 5 tries and show them
        UserGuessNumber getUserGuessNumber;
        int j = 1;
        if(guessNumberRepository.count()<6) {
            for (long i = 1; i <= guessNumberRepository.count(); i++) {
                getUserGuessNumber = guessNumberRepository.findById(j)
                        .orElseThrow(() -> new ResourceNotFoundException("Row does not exist with id: "));

                model.addAttribute("guessId" + j, getUserGuessNumber.getId());
                model.addAttribute("firstGuess" + j, getUserGuessNumber.getFirstGuess());
                model.addAttribute("secondGuess" + j, getUserGuessNumber.getSecondGuess());
                model.addAttribute("thirdGuess" + j, getUserGuessNumber.getThirdGuess());
                model.addAttribute("randomNumber" + j, getUserGuessNumber.getRandomNumber());
                j++;
            }
        }
        //prevents the sixth row to be called
        if(guessNumberRepository.count()>=6) {
            for (long i = 1; i < guessNumberRepository.count(); i++) {
                getUserGuessNumber = guessNumberRepository.findById(j)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: "));

                model.addAttribute("guessId" + j, getUserGuessNumber.getId());
                model.addAttribute("firstGuess" + j, getUserGuessNumber.getFirstGuess());
                model.addAttribute("secondGuess" + j, getUserGuessNumber.getSecondGuess());
                model.addAttribute("thirdGuess" + j, getUserGuessNumber.getThirdGuess());
                model.addAttribute("randomNumber" + j, getUserGuessNumber.getRandomNumber());
                j++;
            }
        }


    }

    //takes the next row's content to the current row
    @PutMapping("/guessNumber.html/{userGuessNumberId}")
    public void editGuessNumberTable(@PathVariable("userGuessNumberId") Integer id){

            UserGuessNumber userGuessNumber1 = guessNumberRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

            UserGuessNumber userGuessNumber2 = guessNumberRepository.findById(id+1)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + (id+1)));

            userGuessNumber1.setFirstGuess(userGuessNumber2.getFirstGuess());
            userGuessNumber1.setSecondGuess(userGuessNumber2.getSecondGuess());
            userGuessNumber1.setThirdGuess(userGuessNumber2.getThirdGuess());
            userGuessNumber1.setRandomNumber(userGuessNumber2.getRandomNumber());
            guessNumberRepository.save(userGuessNumber1);
    }

    //takes the last added row's content and puts it into the 6th row
    @PutMapping("/guessNumber.html/{userGuessNumberId1}")
    public void editGuessNumberLastRow(@PathVariable("userGuessNumberId1") Integer id){
            UserGuessNumber userGuessNumber = guessNumberRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Row does not exist with id:"+id));
            UserGuessNumber userGuessNumber1 = guessNumberRepository.findById(6)
                .orElseThrow(() -> new ResourceNotFoundException("Row does not exist with id:"+6));

            userGuessNumber1.setFirstGuess(userGuessNumber.getFirstGuess());
            userGuessNumber1.setSecondGuess(userGuessNumber.getSecondGuess());
            userGuessNumber1.setThirdGuess(userGuessNumber.getThirdGuess());
            userGuessNumber1.setRandomNumber(userGuessNumber.getRandomNumber());
            guessNumberRepository.save(userGuessNumber1);
    }

    @DeleteMapping("/guessNumber.html/{userGuessNumberId}")
    public void deleteGuessNumber(@PathVariable("userGuessNumberId") Integer id){
        guessNumberRepository.deleteById(id);
    }







    // for the afterNDays
    @PostMapping("/afterNDays.html")
    public void readAfterNDays(@ModelAttribute afterNDays afterNDaysObject, Model model){
        if(!Objects.equals(afterNDaysObject.getWeekDay(), "NotSet")){
        model.addAttribute("message1AfterNDays", /*afterNDaysObject.getnDays()*/"(Including today) It will be " + afterNDaysObject.includingToday()+" after "+afterNDaysObject.getnDays()+" days.");

        model.addAttribute("message2AfterNDays", /*afterNDaysObject.getWeekDay()*/"(Not including today) It will be" + afterNDaysObject.notIncludingToday()+" after "+afterNDaysObject.getnDays()+" days");}
        if(!Objects.equals(afterNDaysObject.getnDays2(), 0)){
        model.addAttribute("we", "It will be "+afterNDaysObject.fromToday()+" after "+afterNDaysObject.getnDays2()+" days.");}


    }


    @PostMapping("/palindromeNumber.html")
    public void palindromeNumberDisplay(@ModelAttribute palindromeNumber palindromeNumberObject, Model model){
        model.addAttribute("isPalindrome", "Answer");
        if(palindromeNumberObject.getCheckNumber()!=0) {
            if (palindromeNumberObject.isPalindrome()) {
                model.addAttribute("isPalindrome", palindromeNumberObject.getCheckNumber() +
                        " is a palindrome number.");
            } else {
                model.addAttribute("isPalindrome", palindromeNumberObject.getCheckNumber() +
                        " is not a palindrome number.");
            }
        }

        if(palindromeNumberObject.getCheckNumberSet()!=0){
            model.addAttribute("allPalindrome", Arrays.toString(palindromeNumberObject.allPalindrome()));
        }
        //System.out.println(Arrays.toString(palindromeNumberObject.allPalindrome()));
    }

    @PostMapping("/LeapYear.html")
    public void leapYearCheck(@ModelAttribute LeapYear leapYear, Model model){
        if(leapYear.isLeapYear()){
            model.addAttribute("leapYearResult", leapYear.getYear()+" is a leap year.");
        } else {
            model.addAttribute("leapYearResult", leapYear.getYear()+" is not a leap year.");
        }


    }



    @PostMapping("/chineseZodiac.html")
    public void chineseZodiacPost(@ModelAttribute ChineseZodiac chineseZodiac, Model model){
        model.addAttribute("zodiacMessage","Chinese zodiac of the year "+
                chineseZodiac.getZodiacYear()+" is "+chineseZodiac.showZodiac());
    }


    @PostMapping("/guessBirthday.html")
    public void guessBirthdayPost(@ModelAttribute GuessBirthday guessBirthday, Model model){
        model.addAttribute("guessBirthdaySets", guessBirthday.getSet1());
        model.addAttribute("guessBirthdaySets2", guessBirthday.getSet2());
        model.addAttribute("guessBirthdaySets3", guessBirthday.getSet3());
        model.addAttribute("guessBirthdaySets4", guessBirthday.getSet4());
        model.addAttribute("guessBirthdaySets5", guessBirthday.getSet5());

        model.addAttribute("guessBirthdayResult", "Your birthday is "+guessBirthday.showResult());
    }
}


