// package com.springboot.spring.helper;

// import java.io.File;
// import java.io.IOException;
// // import java.io.FileOutputStream;
// // import java.io.InputStream;
// import java.nio.file.Files;
// import java.nio.file.Paths;
// import java.nio.file.StandardCopyOption;

// import org.springframework.core.io.ClassPathResource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.multipart.MultipartFile;

// @Component
// public class FileUpload {
//     // public final String path = "/home/ankit/Desktop/SpringBoot/spring/src/main/resources/static/image";  static file path

//     public final String path=new ClassPathResource("static/image/").getFile().getAbsolutePath();
//     public FileUpload()throws IOException{
        
//     }
//     public boolean uploadfile(MultipartFile f) {
//         boolean check = false;

//         try {
//             // InputStream input = f.getInputStream();
//             // byte data[] = new byte[input.available()];
//             // input.read(data);

//             // // writing
//             // FileOutputStream fos = new FileOutputStream(path + "/" + f.getOriginalFilename());
//             // fos.write(data);
//             // fos.close();
//             // fos.flush();

//             Files.copy(f.getInputStream(), Paths.get(path+ File.separator+ f.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
//             check = true;

//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         return check;
//     }
// }

package com.springboot.spring.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload {

    public boolean uploadfile(MultipartFile f) {
        boolean check = false;

        try {
            // Obtain the path dynamically
            String path = new ClassPathResource("static/image/").getFile().getAbsolutePath();

            // Ensure the directory exists
            File directory = new File(path);
            if (!directory.exists()) {
                directory.mkdirs();  // Create the directory if it doesn't exist
            }

            // Save the file
            Files.copy(f.getInputStream(), Paths.get(path + File.separator + f.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            check = true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return check;
    }
}

