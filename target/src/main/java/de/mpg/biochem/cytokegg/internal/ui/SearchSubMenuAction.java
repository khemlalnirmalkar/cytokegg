package de.mpg.biochem.cytokegg.internal.ui;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.AbstractCyAction;

public class SearchSubMenuAction extends AbstractCyAction {
	
	public SearchSubMenuAction(CyApplicationManager cyApplicationManager) {
		super("Search Pathways", cyApplicationManager, null, null);
		setPreferredMenu("Apps.CytoKegg");
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			SearchDialog dialog = new SearchDialog();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Could not handle request", "Error", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
	}
}
