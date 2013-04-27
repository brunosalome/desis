

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.sun.image.codec.jpeg.*;

		public class JPGManager {
			static public void encodeJPG(OutputStream out, byte [] image) throws IOException{
				System.out.println("RODOU COMEÇO");
				int BUFFER = image.length;
				InputStream fs = new ByteArrayInputStream(image);
				JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(fs);
				BufferedImage bImage = decoder.decodeAsBufferedImage();
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
				encoder.encode(bImage);
				fs.close();
				fs = null;
				encoder = null;
				bImage = null;
				System.out.println("RODOU TUDO");
		}
			
}
