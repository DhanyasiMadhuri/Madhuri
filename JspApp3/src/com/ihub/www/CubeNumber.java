package com.ihub.www;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CubeNumber extends TagSupport
{
	private int number;
	
	public void setNumber(int number)
	{
		this.number = number;
	}
	public int doStartTag()throws JspException
	{
		JspWriter out=pageContext.getOut();
		try
		{
			out.println(number*number*number);
		}
		catch(Exception e)
		{
			try
			{
				out.println(e);
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
		return SKIP_BODY;
	}
}
