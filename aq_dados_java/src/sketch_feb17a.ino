const int ledPin = 13;

// setup initializes serial and the button pin
void setup()
{
  Serial.begin(115200);
  Serial.flush();
  pinMode(ledPin, OUTPUT);
}

// loop checks the button pin each time,
// and will send serial if it is pressed
void loop()
{
  int myDelay = 100;
  if (Serial.available()) {
    Serial.println(Serial.readString());
  }
  char myBuffer[250];
  sprintf(
    myBuffer,
    "%d;", random(0,4096)
  );
  Serial.print(myBuffer);
  delay(10);
  sprintf(
    myBuffer,
    "%d;", random(0,4096)
  );
  Serial.print(myBuffer);
  delay(10);
  sprintf(
    myBuffer,
    "%d", random(0,4096)
  );
  delay(myDelay-20);
  Serial.println(myBuffer);
}
