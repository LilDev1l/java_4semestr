package tl;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class AuthTL extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        String auth =   "<input type ='submit' value='Вход'/></br>" +
                        "<input type ='submit' value='Регистрация'/>";
        try {
            JspWriter out = pageContext.getOut();
            out.write(auth);
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
