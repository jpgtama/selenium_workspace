/****************************************************************************
 * $Id: philipscicodetemplates.xml 276 2016-01-01 00:00:00Z philips.java $
 ****************************************************************************
 *                              ICHM
 *                © Koninklijke Philips N.V., 2016.
 *
 * All rights are reserved. Reproduction in whole or in part is
 * prohibited without the written consent of the copyright owner.
 *
 *
 * FILE NAME: DCModifier.java
 * 
 * CREATED: Jan 5, 2018 3:19:02 PM
 *
 * ORIGINAL AUTHOR(S): 310199253
 *
 ***************************************************************************/
package com.evan.autotest.helloSelenium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.text.StrSubstitutor;

/**
 * DCModifier
 * 
 * @author $Author: $
 * @version $Revision: $
 * @since $Date: $
 */
public class DCModifier {
	
	
	private static final String cmdChangePatientName = "dcmodify -v -m \"(0010,0010)=${patientName}\" ${filePath}";
	
	private static final String cmdChangeMRN = "dcmodify -v -m \"(0010,0020)=${mrn}\" ${filePath}";
	
	private static final String cmdChangeStudyUID = "dcmodify -v -m \"(0020,000d)=${studyUID}\" ${filePath}";
	
	private static final String cmdSendFile = "dcmsend -v  -nuc  -aet \"DVTK_STR_SCU\" -aec \"ICHMER\" ${ip} ${port} ${filePath}";
	
	private static final String dcmFilePath = "C:\\Developer_Programs\\DICOM_FILES\\test_dcmtk\\first.dcm";
	
	private static String replace(String str, Map<String, String> valuesMap) {
		StrSubstitutor sub = new StrSubstitutor(valuesMap);
		String resolvedString = sub.replace(str);
		return resolvedString;
	}
	
	public static void main(String[] args) {
		Map<String, String> valuesMap = new HashMap<String, String>();
		valuesMap.put("animal", "quick brown fox");
		valuesMap.put("target", "lazy dog");
		String templateString = "The ${animal} jumped over the ${target}.";
		StrSubstitutor sub = new StrSubstitutor(valuesMap);
		String resolvedString = sub.replace(templateString);
		
		System.out.println(resolvedString);
	}
	
	
	public static void sendNewDicom(String patientName, String mrn, String studyUID){
		// change 
		
		
		
		// send
		
	}
	
	private static void changePatientName(String patientName){
		
	}
	
	public static void main_(String[] args) throws Exception {
		final Process p = Runtime.getRuntime().exec(String.format("CMD /C dcmodify -m \"(0010,0010)=HELLO\" first.dcm"));
		
		List<IOException> ioExceptions = new ArrayList<>();
		
		new Thread(new Runnable() {
			
			
			public void run() {
				BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line = null;
				
				try {
					while ((line = input.readLine()) != null) {
						System.out.println(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
					ioExceptions.add(e);
				}
			}
		}).start();
		
		p.waitFor();
		
		if (ioExceptions.size() > 0) {
			throw new Exception("there are io exceptions.");
		}
	}
	
}
