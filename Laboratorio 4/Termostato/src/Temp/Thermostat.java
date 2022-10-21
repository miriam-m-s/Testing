package Temp;

import java.io.*;
import java.util.*;

// Programmable 
public class Thermostat
{
   private int curTemp;          // temperatura actual
   private int thresholdDiff;    // difencia de temperatura para que salte el aire caliente
   private int timeSinceLastRun; // tiempo desde que paró el calentador
   private int minLag;           // tiempo de espera
   private boolean override;     // el usuario ha usado el mando
   private int overTemp;         // temperatura nueva
   private int runTime;          // tiempo de funcionamiento del aire caliente
   private boolean heaterOn;     // encender el aire caliente?
   private Period period;        
   private DayType day;          
   
   // Determina si se enciende el aire caliente y por cuanto tiempo
   
   public boolean turnHeaterOn (ProgrammedSetting pSet)
   
   {
      int dTemp = pSet.getSetting (period, day);

      if (((curTemp < dTemp - thresholdDiff) ||
           (override && curTemp < overTemp - thresholdDiff)) &&
           (timeSinceLastRun > minLag)) {  // Turn on the heater
         // How long? Assume 1 minute per degree (Fahrenheit)
         int timeNeeded = curTemp - dTemp;
         if (override)
            timeNeeded = curTemp - overTemp;
         setRunTime (timeNeeded);
         setHeaterOn (true);
         return (true);
      }
      else
      {
         setHeaterOn (false);
         return (false);
      }
   } // End turnHeaterOn

   public void setCurrentTemp (int temperature)  { curTemp = temperature; }
   public void setThresholdDiff (int delta)      { thresholdDiff = delta; }
   public void setTimeSinceLastRun (int minutes) { timeSinceLastRun = minutes; }
   public void setMinLag (int minutes)           { minLag = minutes; }
   public void setOverride (boolean value)       { override = value; }
   public void setOverTemp (int temperature)     { overTemp = temperature; }

   // for the ProgrammedSettings
   public void setDay (DayType curDay)           { day = curDay; }
   public void setPeriod (Period curPeriod)      { period = curPeriod; }

   // outputs from turnHeaterOn - need corresponding getters to activate heater
   void setRunTime  (int minutes)         { runTime = minutes; }
   void setHeaterOn (boolean value)       { heaterOn = value; }
} // End Thermostat class