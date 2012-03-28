package gui;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderListener implements ChangeListener {
	private JLabel jl;
	private JSlider js;

	public SliderListener(JLabel jlabel, JSlider jslider) {
		jl = jlabel;
		js = jslider;
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		if (js.getValue() == 0) {
			jl.setText("Current: Default");
		} else {
			jl.setText("Current: " + js.getValue() / 100.0);
		}
	}
}
