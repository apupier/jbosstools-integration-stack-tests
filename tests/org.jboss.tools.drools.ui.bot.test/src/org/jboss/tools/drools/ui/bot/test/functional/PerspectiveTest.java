package org.jboss.tools.drools.ui.bot.test.functional;

import org.jboss.reddeer.junit.runner.RedDeerSuite;
import org.jboss.reddeer.swt.impl.shell.DefaultShell;
import org.jboss.tools.drools.reddeer.perspective.DroolsPerspective;
import org.jboss.tools.drools.reddeer.perspective.JbpmPerspective;
import org.jboss.tools.drools.ui.bot.test.group.SmokeTest;
import org.jboss.tools.drools.ui.bot.test.util.TestParent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@RunWith(RedDeerSuite.class)
public class PerspectiveTest extends TestParent {

	@Test
	@Category(SmokeTest.class)
	public void testOpenDroolsPerspective() {
		DroolsPerspective perspective = new DroolsPerspective();
		perspective.open();

		DefaultShell shell = new DefaultShell();
		Assert.assertTrue("Drools perspective was not opened.", shell.getText().startsWith("Drools"));
	}

	@Test
	@Category(SmokeTest.class)
	public void testOpenJbpmPerspective() {
		JbpmPerspective perspective = new JbpmPerspective();
		perspective.open();

		DefaultShell shell = new DefaultShell();
		Assert.assertTrue("jBPM perspective was not opened.", shell.getText().startsWith("jBPM"));
	}
}
