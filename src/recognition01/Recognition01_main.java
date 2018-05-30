package recognition01;

import java.io.File;
import java.io.FileNotFoundException;

import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectFacesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;

public class Recognition01_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		VisualRecognition service = new VisualRecognition("2018-03-19");
		service.setEndPoint("https://gateway.watsonplatform.net/visual-recognition/api");

		IamOptions options = new IamOptions.Builder()
				.apiKey("{EYT41cEOK7QwwrYiNbJJAU_OzYa4I2h6_1kmsmCtCyf9}")
				.build();
		service.setIamCredentials(options);

		DetectFacesOptions detectFacesOptions = null;
		try {
			detectFacesOptions = new DetectFacesOptions.Builder()
			  .imagesFile(new File("img/woman.jpg"))
			  .build();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DetectedFaces result = service.detectFaces(detectFacesOptions).execute();
		System.out.println(result);
	}

}
