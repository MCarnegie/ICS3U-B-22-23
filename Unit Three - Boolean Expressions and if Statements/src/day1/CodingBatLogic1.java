package day1;

public class CodingBatLogic1 {
    
    public boolean love6(int a, int b) {
            if(a == 6 || b == 6)
              return true;
            else if (a + b == 6 || Math.abs(a-b) == 6)
              return true;
            else
              return false;
            
    }

    public boolean cigarParty(int cigars, boolean isWeekend) {
        if(isWeekend == false && cigars>=40 && cigars<=60)
            return true;
        if(isWeekend == true && cigars>=40)
            return true;
          
        
        return false;
    }

    public int dateFashion(int you, int date) {
        if(you<=2 || date<=2)
          return 0;
        
        else if(you>=8  || date>=8)
          return 2;
          
        return 1;
        
        
    }

    public boolean squirrelPlay(int temp, boolean isSummer) {
        if(isSummer == true && temp>=60 && temp<=100)
          return true;
        
        if(temp>=60 && temp<=90)
          return true;
        
        return false;
    }
    
    public int caughtSpeeding(int speed, boolean isBirthday) {
        if(isBirthday)
          speed -= 5;
        
        if(speed<=60)
          return 0;
        if(speed>=61 && speed<=80)
          return 1;
        if(speed >= 81)
          return 2;
          
        return 5;
        
    }

    public int sortaSum(int a, int b) {
      if((a+b)>=10 && (a+b)<=19 )
      return 20;
      
      return a+b;
    }

    public String alarmClock(int day, boolean vacation) {
  
      if(vacation && day>=1 && day<=5)
      return "10:00";
      else if(vacation && day == 6)
      return "off";
      else if(vacation && day == 0)
      return "off";
      else if(day>=1 && day<=5)
      return "7:00";
      else
      return "10:00";
      
    }
  
    public boolean in1To10(int n, boolean outsideMode) {
      if(outsideMode && n>=10)
      return true;
      if(outsideMode && n<=1)
      return true;
      if(!outsideMode&&n<=10 && n>=1)
      return true;
      
      return false;
    }
  
    public boolean specialEleven(int n) {
      if((n%11) == 0 || ((n-1)%11) == 0 )
      return true;
      
      return false;
    }
    
    public boolean more20(int n) {
      if((n-2)%20 == 0 || ((n-1)%20) == 0 )
      return true;
      
      return false;
    }
    
    public boolean old35(int n) {
  
      if((n%3) == 0 && (n%5) == 0)
        return false;
      else if((n%3) == 0 || (n%5) == 0)
        return true;
      else
        return false;
      
      
    }
    
    
    public boolean less20(int n) {
      if((n+2)%20 == 0 || ((n+1)%20) == 0 )
      return true;
      
      return false;
        
      
    }
    
    
    public boolean nearTen(int num) {
      if((num%10)>2 && (num%10)<8)
      return false;
      else
      return true;
      
    }

    public int teenSum(int a, int b) {
      if((a>=13 && a<=19) || (b>=13 && b<=19))
      return 19;
      else
      return a+b;
      
    }
    
    
    public boolean answerCell(boolean isMorning, boolean isMom, boolean isAsleep) {
      if(isAsleep)
      return false;
      else if(isMorning && isMom)
      return true;
      else if(isMorning && !isMom)
      return false;
      else
      return true;
    }
    
    
    public int teaParty(int tea, int candy) {
      if(tea<5 || candy<5)
      return 0;
      else if(2*candy <= tea || 2*tea <= candy)
      return 2;
      else
      return 1;
    }
    
    
    public String fizzString(String str) {
      String f = "f";
      String b = "b";
      String firstl = str.substring(0,1);
      String lastl = str.substring(str.length()-1);
      if(firstl.equals(f) && lastl.equals(b))
      return "FizzBuzz";
      else if((firstl.equals(f)))
      return "Fizz";
      else if(lastl.equals(b))
      return "Buzz";
      else
      return str;
      
    }

    public String fizzString2(int n) {
      if((n%3) == 0 && (n%5) == 0)
        return "FizzBuzz!";
      else if((n%3) == 0)
        return "Fizz!";
      else if((n%5) == 0)
        return "Buzz!";
      else
        return n+"!";
        
    }
    
    public boolean twoAsOne(int a, int b, int c) {
      if(a + b == c || a + c == b || c + b == a)
        return true;
      else
        return false;
    }


    public boolean inOrder(int a, int b, int c, boolean bOk) {
      if(bOk && c>b)
        return true;
      else if (c>b && b>a)
        return true;
      else
      return false;
    }
    
    public boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
      if(equalOk && a<=b && b<=c && c>=b)
        return true;
      else if(a<b && b<c && c>b)
        return true;
      return false;
    }
    
    public boolean lastDigit(int a, int b, int c) {

      int aL = a%10;
      int bL = b%10;
      int cL = c%10;
      
      if((aL == bL || aL == cL) ||(bL == aL || bL == cL) || (cL == aL || cL == bL) )
        return true;
      else
      return false;
      
    }
    
    public boolean lessBy10(int a, int b, int c) {
      if(a<=b-10 || a<=c-10 || c<=b-10 || b<=a-10 || c<=a-10 ||b<=c-10)
        return true;
      else
      return false;
    }
    
    public int withoutDoubles(int die1, int die2, boolean noDoubles) {
      if(noDoubles && die1 == die2){
        die1 +=1;
        if(die1>=7){
        die1 = 1;
        return die1 + die2;
        }else{
        return die1 + die2;
        }
      }else{
        return die1 + die2;
      }
      
    }
    
    public int maxMod5(int a, int b) {
      if(a==b){
        return 0;
      }else if((a%5) == (b%5)){
        if(a<b){
          return a;
        }else{
          return b;
        }
      }else if (a>b){
        return a;
      }else{
        return b;
      }
      
      
        
    }
    
    public int redTicket(int a, int b, int c) {
      if(a == 2 && b == 2 && c == 2 )
        return 10;
      else if(a == b && b == c && a == c)
        return 5;
      else if(a != b && a != c)
        return 1;
      else
        return 0;
    }
    
    
    public int greenTicket(int a, int b, int c) {
      if(a == b && b == c && c == a)
        return 20;
      else if(a == b || b == c || c == a )
        return 10;
      else
        return 0;
    }
    
      
      
    
}
