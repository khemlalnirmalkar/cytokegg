package de.mpg.biochem.cytokegg.internal.service;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;

import de.mpg.biochem.cytokegg.internal.Pathway;
import de.mpg.biochem.cytokegg.internal.util.Item;
import junit.framework.TestCase;

public class KeggServiceTest extends TestCase{

	protected KeggService kegg;
	
	//Init service
	protected void setUp(){
		kegg = KeggService.getInstance();
	}
	
	public void testGetPathway() throws IOException{
		Pathway path = kegg.getPathway("hsa05130");
		
		Assert.assertTrue("Pathways should have same input id", path.getId().equals("hsa05130"));
		Assert.assertTrue("Pathways should have description", path.getDescription().length() > 0);
		Assert.assertFalse("Pathways should have genes", path.getGenes().isEmpty());
	}
	
	public void testFind() throws IOException{
		
		List<Item> paths = kegg.find("apoptosis");
		Assert.assertTrue("Genes return should be more than zero (" + paths.size() + ")", paths.size() > 0);
		
		//Return empty array
		paths = kegg.find("kjhflkjhf");
		Assert.assertTrue("Genes return should be zero (" + paths.size() + ")", paths.size() == 0);
	}
	
	public void testGetOrganisms() throws IOException{
		List<Item> orgs = kegg.getOrganisms();
		Assert.assertTrue("Organisms should be more than zero (" + orgs.size() + ")", orgs.size() > 0);
	}
	
	public void testGetPathwaysByOrg() throws IOException{
		List<Item> paths = kegg.getPathwaysByOrg("hsa");
		Assert.assertTrue("Pathways should be more than zero (" + paths.size() + ")", paths.size() > 0);
	}
	
	public void testGetOrganismIds() throws IOException{
		List<Item> ids = kegg.getOrganismIds("hsa", "uniprot");
		Assert.assertTrue("Pathways should be more than zero (" + ids.size() + ")", ids.size() > 0);
	}
}
