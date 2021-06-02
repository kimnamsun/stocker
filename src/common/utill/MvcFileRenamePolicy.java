package common.utill;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MvcFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File oldFile) {
		File newFile = null;
		
		do {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS_");
			
			int rndNum = (int)(Math.random()*1000);
			String oldName = oldFile.getName();
			String ext = "";
			int dotIndex = oldName.lastIndexOf(".");
			if(dotIndex > -1) {
				ext = oldName.substring(dotIndex); 
			
			String newName = sdf.format(new Date()) + rndNum + ext;
			newFile = new File(oldFile.getParent(), newName);
			
		}while(!createNewFile(newFile));
		return newFile;
	}

	private boolean createNewFile(File f) {
		try {
			return f.createNewFile();
		} catch (IOException ignored) {
			return false;
		}
	}

}
