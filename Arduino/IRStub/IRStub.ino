
int ledPin = 13;
int reading = 0;

class Sensor{
  public:
    int irPin = 0;
    int getIRReading(){
      return analogRead(irPin);
    }
};

class SensorStub : public Sensor{
    int test = 0;
    int cycle = 0;
    
    public:
      SensorStub(int testNumber){
        test = testNumber;
      }
      int getIRReading(){

        //return values for IR ON
        if(test == 1)
        {
          if(cycle==0){
            cycle++;
            return 700;
          }
          else
            return 100;
        }//return values for IR  OFF
        else if(test == 2)
        {
          if(cycle==0){
            cycle++;
            return 300;
          }
          else
            return 100;
          
        }
        else if(test == 3)
        {
          if(cycle==0){
            cycle++;
            return 3000;
          }
          else
            return 100;          
        }
      }
};

//for test
class Control{
  public:
    const int threshold = 400;
    
    //Sensor *sensor;
    SensorStub *sensor;

    Control(SensorStub *newSensorStub)
    {
      sensor = newSensorStub;
    }
    boolean getIR(){
      //turn on IR led
      digitalWrite(ledPin, 1);
      delay(10);
      int on = sensor->getIRReading();
      //display reading
      //Serial.print("readOn=");
      //Serial.print(on);
      //Serial.print("\n");

      //turn off IR led
      digitalWrite(ledPin, 0);
      delay(10);
      int off = sensor->getIRReading();
      //display reading
      //Serial.print("readOff=");
      //Serial.print(off);
      //Serial.print("\n");

      int difference = on - off;
      
      if(difference < 0 || difference > 1023)
        return false;
        
      
      return difference > threshold;
    }

};
/*
//for regular IR reading
class Control{
  public:
    const int threshold = 400;
    
    Sensor *sensor;

    Control(Sensor *newSensor)
    {

      sensor = newSensor;
    }

    boolean getIR(){
      //turn on IR led
      digitalWrite(ledPin, 1);
      delay(1000);
      int on = sensor->getIRReading();
      //display reading
      Serial.print("readOn=");
      Serial.print(on);
      Serial.print("\n");

      //turn off IR led
      digitalWrite(ledPin, 0);
      delay(1000);
      int off = sensor->getIRReading();
      //display reading
      Serial.print("readOff=");
      Serial.print(off);
      Serial.print("\n");

      int difference = on - off;
      
      if(difference < 0 || difference > 1023)
        return false;
        
      return difference > threshold;
    }

};
*/

class IRTest{
  public:
    Control *control;
    IRTest(Control *newControl){
      control = newControl;
    }
    
    //test methods
    void testGetIR_on(){
      boolean retVal = control->getIR();
      if(retVal == true){
          Serial.print("method: testGetIR_on(). Result: Pass.\n");
      }
      else
          Serial.print("method: testGetIR_on(). Result: Fail.\n");
    }
    void testGetIR_off(){
      boolean retVal = control->getIR();
      if(retVal == false)
          Serial.print("method: testGetIR_off(). Result: Pass.\n");
      else
          Serial.print("method: testGetIR_off(). Result: Fail.\n");

    }
    void testGetIR_invalid(){
      boolean retVal = control->getIR();
      if(retVal == false)
          Serial.print("method: testGetIR_invalid(). Result: Pass.\n");
      else
          Serial.print("method: testGetIR_invalid(). Result: Fail.\n");
    }

    
};

//global vars

//Control *control;
IRTest *irtest;

//setup code
void setup() {

  //serial monitor baud rate
  Serial.begin(9600);
  
  //set DDR
  pinMode(ledPin, OUTPUT);

  //control = new Control(new Sensor());

}

void loop() {
  Serial.print("Beginning stub testing for Arduino\n");
  irtest = new IRTest(new Control(new SensorStub(1)));
  irtest->testGetIR_on();
  irtest = new IRTest(new Control(new SensorStub(2)));
  irtest->testGetIR_off();
  irtest = new IRTest(new Control(new SensorStub(3)));
  irtest->testGetIR_invalid();
  Serial.print("Testing complete\n");
  while(1){
    //control->getIR();
  }
  //display boolean
  //Serial.print("boolean=");
  //Serial.print(on);
  //Serial.print("\n");
  
}
