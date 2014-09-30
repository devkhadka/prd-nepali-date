package org.pentaho.sample.formula;

import org.pentaho.reporting.libraries.formula.function.AbstractFunctionDescription;
import org.pentaho.reporting.libraries.formula.function.FunctionCategory;
import org.pentaho.reporting.libraries.formula.function.datetime.DateTimeFunctionCategory;
import org.pentaho.reporting.libraries.formula.typing.Type;
import org.pentaho.reporting.libraries.formula.typing.coretypes.DateTimeType;
import org.pentaho.reporting.libraries.formula.typing.coretypes.TextType;

public class NepaliDateDescription extends AbstractFunctionDescription {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NepaliDateDescription() {
		 super("NEPALIDATE", "org.pentaho.sample.formula.NepaliDate-Function");
	}

	@Override
	public FunctionCategory getCategory() {
		 return DateTimeFunctionCategory.CATEGORY;
	}

	@Override
	public int getParameterCount() {
		return 1;
	}

	@Override
	public Type getParameterType(int arg0) {
		 return DateTimeType.DATE_TYPE;
	}

	@Override
	public Type getValueType() {
		return TextType.TYPE;
	}

	@Override
	public boolean isParameterMandatory(int arg0) {
		return true;
	}

}
