package io.pivotal.akitada;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gemstone.gemfire.cache.RegionEvent;
import com.gemstone.gemfire.cache.CacheListener;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;

@SuppressWarnings("rawtypes")
public class CacheListenerVisualizer implements CacheListener, Declarable {
	static Log log = LogFactory.getLog(CacheListenerVisualizer.class);
	
	private final String name = "CacheListener Test";
	
	// Need for graphical application
	private static JFrame frame;
	private static JPanel p1;
	private static JTextArea tArea;
	private static JScrollPane sp;
	
	public static void main(String[] args) {	
		CacheListenerVisualizer gui = new CacheListenerVisualizer();
	
		//System.setProperty("spring.profiles.active","server");
		@SuppressWarnings("resource")
		ApplicationContext context= new ClassPathXmlApplicationContext("META-INF/spring/gemfire/cache-config.xml");

		// open GUI
		gui.setVisible(true);
		log.info("Client application started.");
	}
	
	public CacheListenerVisualizer() {
		frame = new JFrame();
		frame.setTitle(name);
		frame.setBounds(100, 100, 400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p1 = new JPanel();
		tArea = new JTextArea(10,20);
		tArea.setEditable(false);
		tArea.setLineWrap(true);
		tArea.setFont(new Font("Arial", Font.PLAIN, 20));
		sp = new JScrollPane(tArea);
		p1.add(sp);

		frame.getContentPane().add(p1, BorderLayout.CENTER);
	}
	
	@Override
	public void init(Properties arg0) {		
	}
	
	private void setVisible(boolean flag) {
		frame.setVisible(flag);
	}

	@Override
	public void close() {		
	}

	@Override
	public void afterCreate(EntryEvent e) {
		handleEvent("afterCreate", e);
	}

	@Override
	public void afterDestroy(EntryEvent e) {
		handleEvent("afterDestroy", e);		
	}

	@Override
	public void afterInvalidate(EntryEvent e) {
		handleEvent("afterInvalidate", e);
	}

	@Override
	public void afterRegionClear(RegionEvent e) {
		handleEvent("afterRegionClear", e);		
	}

	@Override
	public void afterRegionCreate(RegionEvent e) {
		handleEvent("afterRegionCreate", e);	
	}

	@Override
	public void afterRegionDestroy(RegionEvent e) {
		handleEvent("afterRegionDestroy", e);
	}

	@Override
	public void afterRegionInvalidate(RegionEvent e) {
		handleEvent("afterRegionInvalidate", e);
	}

	@Override
	public void afterRegionLive(RegionEvent e) {
		handleEvent("afterRegionLive", e);
	}

	@Override
	public void afterUpdate(EntryEvent e) {
		handleEvent("afterUpdate", e);
	}
	
	private void handleEvent(String action, EntryEvent e) {
		tArea.append(action + " is called: key=" + e.getKey() +"\n");
		tArea.setCaretPosition(tArea.getDocument().getLength());
	}
	
	private void handleEvent(String action, RegionEvent e) {
		tArea.append(action + " is called: " + e.getOperation().toString() + "\n");
		tArea.setCaretPosition(tArea.getDocument().getLength());
	}
}
