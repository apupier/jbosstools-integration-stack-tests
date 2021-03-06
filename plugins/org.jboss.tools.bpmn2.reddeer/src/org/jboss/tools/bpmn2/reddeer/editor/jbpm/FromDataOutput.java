package org.jboss.tools.bpmn2.reddeer.editor.jbpm;

import org.jboss.reddeer.swt.api.Combo;
import org.jboss.reddeer.swt.impl.button.PushButton;
import org.jboss.reddeer.swt.impl.combo.LabeledCombo;
import org.jboss.reddeer.swt.impl.group.DefaultGroup;
import org.jboss.reddeer.swt.impl.text.LabeledText;
import org.jboss.tools.bpmn2.reddeer.editor.MappingSide;
import org.jboss.tools.bpmn2.reddeer.editor.dialog.jbpm.DataTypeDialog;

/**
 * Represents the target side of parameter mapping.
 */
public class FromDataOutput implements MappingSide {

	private String name;

	private String dataType;

	/**
	 * @deprecated
	 * @param name
	 */
	public FromDataOutput(String name) {
		this(name, "");
	}

	/**
	 * 
	 * @param name
	 * @param dataType
	 */
	public FromDataOutput(String name, String dataType) {
		this.name = name;
		this.dataType = dataType;
	}

	@Override
	public void setUp() {
		new LabeledText("Name").setText(name);

		Combo dataTypeCombo = new LabeledCombo(new DefaultGroup("From"), "Data Type");
		if (!dataTypeCombo.getItems().contains(dataType)) {
			new PushButton(0).click();
			new DataTypeDialog().add(dataType);
		}
		dataTypeCombo.setSelection(dataType);
	}

	@Override
	public String getName() {
		return name;
	}

}
