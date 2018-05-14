package io.github.oliviercailloux.y2018.apartments.iconDisplay;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.oliviercailloux.y2018.apartments.distance.DistanceSubway;


public class DisplayIcon {

	static Logger displayIcon = LoggerFactory.getLogger(DisplayIcon.class);
	
	public static void main(String[] args) throws IOException {
		try(InputStream f = DisplayIcon.class.getResourceAsStream("logo.png")){
			Display d = new Display( );
			Shell s = new Shell(d);
			
			displayIcon.info("The shell has been initialized");
			
			s.setSize(500,500);
			Image i = new Image(d, f);
			s.setImage(i);
			s.setText("Apartments");
			s.open( );
			
			displayIcon.info("The image is perfectly loaded");
			while(!s.isDisposed( )){
				if(!d.readAndDispatch( ))
					d.sleep( );
			}
			i.dispose();
			s.dispose();
			d.dispose();
		}
		catch(IOException e)
		{
			displayIcon.info("Fail to open the stream or the stream has been interrupted");
			throw e;
		}
	}
}
