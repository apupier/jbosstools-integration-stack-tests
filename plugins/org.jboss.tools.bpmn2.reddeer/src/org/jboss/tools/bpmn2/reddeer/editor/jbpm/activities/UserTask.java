package org.jboss.tools.bpmn2.reddeer.editor.jbpm.activities;

import org.jboss.reddeer.swt.impl.button.LabeledCheckBox;
import org.jboss.reddeer.swt.impl.button.PushButton;
import org.jboss.reddeer.swt.impl.shell.DefaultShell;
import org.jboss.reddeer.swt.impl.tab.DefaultTabItem;
import org.jboss.reddeer.swt.impl.text.LabeledText;
import org.jboss.tools.bpmn2.reddeer.editor.Element;
import org.jboss.tools.bpmn2.reddeer.editor.ElementType;
import org.jboss.tools.bpmn2.reddeer.editor.jbpm.ParameterMapping;
import org.jboss.tools.bpmn2.reddeer.editor.properties.PropertiesTabs;
import org.jboss.tools.bpmn2.reddeer.editor.properties.SectionToolItemButton;
import org.jboss.tools.bpmn2.reddeer.properties.setup.AddActorSetUp;
import org.jboss.tools.bpmn2.reddeer.properties.setup.AddLocalVariableSetUp;
import org.jboss.tools.bpmn2.reddeer.properties.setup.ParameterMappingSetUp;
import org.jboss.tools.bpmn2.reddeer.properties.setup.CheckBoxSetUp;
import org.jboss.tools.bpmn2.reddeer.properties.setup.LabeledTextSetUp;
import org.jboss.tools.bpmn2.reddeer.properties.setup.RemoveActorSetUp;
import org.jboss.tools.bpmn2.reddeer.properties.setup.ScriptSetUp;

/**
 * 
 */
public class UserTask extends Task {

	/**
	 * 
	 * @param name
	 */
	public UserTask(String name) {
		super(name, ElementType.USER_TASK);
	}

	public UserTask(Element element) {
		super(element);
	}

	/**
	 * 
	 * @param name
	 */
	public void setTaskName(String name) {
		propertiesHandler.setUp(new LabeledTextSetUp(PropertiesTabs.USER_TASK_TAB, "Task Name", name));
	}

	public String getTaskName() {
		propertiesHandler.selectTabInPropertiesView(PropertiesTabs.USER_TASK_TAB);
		return new LabeledText("Task Name").getText();

	}

	/**
	 * 
	 * @param priority
	 */
	public void setPriority(int priority) {
		setPriority(String.valueOf(priority));
	}

	/**
	 * USE ONLY FOR numbers bigger than int
	 * 
	 * @param priority
	 */
	public void setPriority(String priority) {
		propertiesHandler.setUp(new LabeledTextSetUp(PropertiesTabs.USER_TASK_TAB, "Priority", priority));
	}

	/**
	 * 
	 * @param comment
	 */
	public void setComment(String comment) {
		propertiesHandler.setUp(new LabeledTextSetUp(PropertiesTabs.USER_TASK_TAB, "Comment", comment));
	}

	/**
	 * 
	 * @param id
	 */
	public void setGroupId(String id) {
		propertiesHandler.setUp(new LabeledTextSetUp(PropertiesTabs.USER_TASK_TAB, "Group Id", id));

	}

	public String getGroupId() {
		propertiesHandler.selectTabInPropertiesView(PropertiesTabs.USER_TASK_TAB);
		return new LabeledText("Group Id").getText();
	}

	/**
	 * 
	 * @param skippable
	 */
	public void setSkippable(boolean skippable) {
		propertiesHandler.setUp(new CheckBoxSetUp(PropertiesTabs.USER_TASK_TAB, "Skippable", skippable));

	}

	public boolean getSkippable() {
		propertiesHandler.activateGraphitiPropertiesView();
		new DefaultShell("Edit User Task");
		new DefaultTabItem(PropertiesTabs.USER_TASK_TAB).activate();
		boolean result = new LabeledCheckBox("Skippable").isChecked();
		new PushButton("OK").click();
		return result;
	}

	/**
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		propertiesHandler.setUp(new LabeledTextSetUp(PropertiesTabs.USER_TASK_TAB, "Content", content));
	}

	/**
	 * 
	 * @param locale
	 */
	public void setLocale(String locale) {
		propertiesHandler.setUp(new LabeledTextSetUp(PropertiesTabs.USER_TASK_TAB, "Locale", locale));
	}

	/**
	 * 
	 * @param actor
	 */
	public void addActor(String actor) {
		propertiesHandler.setUp(new AddActorSetUp(PropertiesTabs.USER_TASK_TAB, actor));
	}

	public void removeActor(String actorName) {
		propertiesHandler.setUp(new RemoveActorSetUp(PropertiesTabs.USER_TASK_TAB, actorName));
	}

	/**
	 *
	 * @param value
	 */
	public void setIsForCompensation(boolean value) {
		propertiesHandler.setUp(new CheckBoxSetUp(PropertiesTabs.USER_TASK_TAB, "Is For Compensation", value));
	}

	/**
	 *
	 * @param language
	 * @param script
	 */
	public void setOnEntryScript(String language, String script) {
		propertiesHandler.setUp(new ScriptSetUp(PropertiesTabs.USER_TASK_TAB, "On Entry Script", language, script));
	}

	/**
	 * 
	 * @param language
	 * @param script
	 */
	public void setOnExitScript(String language, String script) {
		propertiesHandler.setUp(new ScriptSetUp(PropertiesTabs.USER_TASK_TAB, "On Exit Script", language, script));
	}

	/**
	 *
	 * @param parameter
	 */
	public void addParameterMapping(ParameterMapping parameterMapping) {
		propertiesHandler.setUp(new ParameterMappingSetUp(parameterMapping, SectionToolItemButton.ADD));
	}

	public void addLocalVariable(String varName, String dataType) {
		propertiesHandler.setUp(new AddLocalVariableSetUp(PropertiesTabs.USER_TASK_TAB, varName, dataType));
	}

}
