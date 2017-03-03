const int ledPin = 13;

// setup initializes serial and the button pin
void setup()
{
  Serial.begin(9600);
  Serial.flush();
  pinMode(ledPin, OUTPUT);
}

// loop checks the button pin each time,
// and will send serial if it is pressed
void loop()
{
  if (Serial.available()) {
    Serial.println(Serial.readString());
  }
  char myBuffer[250];
  sprintf(
    myBuffer,
    "[{\"sensorId\":1,\"timestamp\":0,\"value\":%d},", random(503,504)
  );
  Serial.print(myBuffer);
  delay(10);
  sprintf(
    myBuffer,
    "{\"sensorId\":2,\"timestamp\":0,\"value\":%d},", random(503,504)
  );
  Serial.print(myBuffer);
  delay(10);
  sprintf(
    myBuffer,
    "{\"sensorId\":3,\"timestamp\":0,\"value\":%d}]", random(503,504)
  );
//  sprintf(
//    myBuffer,
//    "%d,", random(0,100)
//  );
//  Serial.print(myBuffer);
//  delay(10);
//  sprintf(
//    myBuffer,
//    "%d,", random(0,100)
//  );
//  Serial.print(myBuffer);
//  delay(10);
//  sprintf(
//    myBuffer,
//    "%d", random(0,100)
//  );
  Serial.println(myBuffer);
  delay(10);
}
