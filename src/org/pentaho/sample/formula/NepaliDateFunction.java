package org.pentaho.sample.formula;

import java.util.Date;

import nepalidate.NepaliDateConverterUtil;

import org.pentaho.reporting.libraries.formula.EvaluationException;
import org.pentaho.reporting.libraries.formula.FormulaContext;
import org.pentaho.reporting.libraries.formula.LibFormulaErrorValue;
import org.pentaho.reporting.libraries.formula.function.Function;
import org.pentaho.reporting.libraries.formula.function.ParameterCallback;
import org.pentaho.reporting.libraries.formula.lvalues.TypeValuePair;
import org.pentaho.reporting.libraries.formula.typing.TypeRegistry;
import org.pentaho.reporting.libraries.formula.typing.coretypes.TextType;

public class NepaliDateFunction implements Function {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NepaliDateFunction(){
		
	}
	
	@Override
	public String getCanonicalName() {
		return "NEPALIDATE";
	}

	@Override
	public TypeValuePair evaluate(FormulaContext context,
			ParameterCallback parameters) throws EvaluationException {
		 if (parameters.getParameterCount() != 1)
		    {
		      throw EvaluationException.getInstance(LibFormulaErrorValue.ERROR_ARGUMENTS_VALUE);
		    }
		 
		 final TypeRegistry typeRegistry = context.getTypeRegistry();

		    final Date d = typeRegistry.convertToDate(parameters.getType(0), parameters.getValue(0));
		    if (d == null)
		    {
		      throw EvaluationException.getInstance(LibFormulaErrorValue.ERROR_INVALID_ARGUMENT_VALUE);
		    }
		    String nd= NepaliDateConverterUtil.convertToNepali(d);
		    return new TypeValuePair(TextType.TYPE, nd);

	}

}
