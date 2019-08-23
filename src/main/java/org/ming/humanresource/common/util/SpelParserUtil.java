package org.ming.humanresource.common.util;


import org.ming.humanresource.common.model.OperatorLog;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * 根据形参获取实参
 * @author MingXiangjun
 * @create 2017-12-14 11:06
 */
public class SpelParserUtil {

    public SpelParserUtil() {
        // Utility clazz default constructor
    }

    private static ExpressionParser parser = new SpelExpressionParser();

    /**
     * 解析SpeEl表达式，获取值
     * @param key El表达式：#id
     * @param params 形参：方法声明里面的参数
     * @param args 实际参数：传递的参数
     * @return
     */
    public static Object getParamArg(String key, String[] params, Object[] args){
        Expression expression = parser.parseExpression(key);
        EvaluationContext context = new StandardEvaluationContext();
        if (args.length<=0){
            return null;
        }
        for (int i=0;i<args.length;i++){
            context.setVariable(params[i],args[i]);
        }
        return expression.getValue(context,Object.class);
    }
}
