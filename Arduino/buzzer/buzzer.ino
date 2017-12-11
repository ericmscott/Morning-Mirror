const int buzzer = 3; //buzzer to arduino pin 9

int i = 0;
void setup(){
 
  pinMode(buzzer, OUTPUT); // Set buzzer - pin 9 as an output

}

void loop(){
 
 if( i < 5){
  tone(buzzer, 4500); // Send 5KHz sound signal...
  delay(100);        // ...for 1 sec
  noTone(buzzer);     // Stop sound...
  delay(100);        // ...for 1sec
  i++;
 }
  
}
