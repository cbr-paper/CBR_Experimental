## Requirements

 - Eclipse with AJDT installed
 - Z3 (https://github.com/Z3Prover/z3)
 - Sikulix (http://sikulix.com)
 - Maven

# Instructions:

1. in the console, go to jbse/ folder and launch: $mvn eclipse:eclipse
2. Open Eclipse and import the four projects included in this folder (conditions/, fragmented/, jbse/ and monitor/)
3. import the 3 launchers in Eclipse (run/debug configurations) contained in folder launchers/

# Symbolic execution part

5. Go to fragmented/src/main/java/defs/Defs.java
6. Set z3Path
7. Launch ArgoLauncher (this could take > 1 hour): this will produce all the symbolic results in folders fragmented/fragmented, out/ and serialized/. Besides, it will compile the functions to be evaluated at runtime contained in conditions/ folder. Note that this will generate more than 5000 functions.

# Monitoring with CBR for calibration

8. Within monitor/ folder, you may configure the file src/main/resources/config.properties: sampler_probability (sampling monitor probability), sample_length (how long the sampling monitor traces should be) and cbr_probability (probability of CBR [0,1]).
9. Within the same folder, you may configure the monitors to enable during runtime in the file src/main/resources/META-INF/aop.xml (ActionAspect should be always enable since this monitor the system response time), now the CBR monitor is also enabled.
10. Launch the ArgoUML launcher previously loaded in Eclipse (this will launch the ArgoUML application with CBR).
11. Use ArgoUML normally, or launch one of the scripts located in the root of this folder /TestScripts
12. The results will be available detections/ (srt measures) and logs/ (expressions + results + traces)

# Function Filtering
13. After running the application go to logs/15XXXXXXXXXX/ folder, and move the expressions.log and results.log to logs/ folder (e.g., one level higher).
14. Inside fragmented project launch SecondPhaseLauncher (this filters out all the functions that are not relevant to the problem), also this will compile the new functions to be used during runtime. Note: this procedure may need extra memory: increase the Xms and Xmx options of the Java VM.

# Monitoring with CBR, Sampling and Naive monitors.

15. Go back to monitor/ folder, and modify the parameters of step 8, also you may select the type of monitor to be used as explained before in step 9.
16. Launch the ArgoUML launcher.
 






