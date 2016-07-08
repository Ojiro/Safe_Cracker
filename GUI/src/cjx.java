import java.io.File;
import javax.swing.filechooser.FileFilter;

//class creates a file filter used by the file selector to filter out anything 
// that isn't a .cjx file or a directory
 public class cjx extends FileFilter{
			
			@Override
			public boolean accept(File arg0) {
				String extension=arg0.getPath();
				//extension.contains(".cjx");
				
				if(extension.endsWith(".cjx") || arg0.isDirectory())
					return true;
				else
					return false;
					
			}

			@Override
			public String getDescription() {
				return null;
			}
			
		}