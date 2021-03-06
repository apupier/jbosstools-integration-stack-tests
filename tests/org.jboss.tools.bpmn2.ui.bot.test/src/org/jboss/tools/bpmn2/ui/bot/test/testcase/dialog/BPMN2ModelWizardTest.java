package org.jboss.tools.bpmn2.ui.bot.test.testcase.dialog;

import org.jboss.reddeer.eclipse.jdt.ui.ProjectExplorer;
import org.jboss.reddeer.eclipse.jdt.ui.packageexplorer.PackageExplorer;
import org.jboss.reddeer.jface.exception.JFaceLayerException;
import org.jboss.tools.bpmn2.reddeer.dialog.BPMN2ModelWizard;
import org.jboss.tools.bpmn2.reddeer.dialog.JBPMProjectWizard;
import org.jboss.tools.bpmn2.ui.bot.test.requirements.ProcessRuntimeRequirement.ProcessRuntime;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Verify functionality of the bpmn2 model wizard.
 */
@ProcessRuntime()
public class BPMN2ModelWizardTest {

	@BeforeClass
	public static void createProject() {
		new JBPMProjectWizard().execute("TestProject");
	}

	@AfterClass
	public static void deleteProject() throws Exception {
		new PackageExplorer().getProject("TestProject").delete(true);
	}

	@Test
	public void newModelTest() throws Exception {
		new BPMN2ModelWizard().execute(new String[] { "TestProject" }, "SampleProcess.bpmn2");
		Assert.assertTrue(new ProjectExplorer().getProject("TestProject").containsItem("SampleProcess.bpmn2"));
	}

	@Test
	public void newModelFormValidationTest() throws Exception {
		BPMN2ModelWizard wizard = new BPMN2ModelWizard();
		try {
			wizard.execute("");
		} catch (JFaceLayerException e) {
			Assert.assertEquals("Button '&Finish' is not enabled", e.getMessage());
		} finally {
			wizard.cancel();
		}
	}

}
