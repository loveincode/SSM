package com.hyf.loveincode.bean;

import java.io.Serializable;

/**
*
* @author loveincode
* @data Sep 19, 2017 2:09:05 PM
*/
public class Rediscontent implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
