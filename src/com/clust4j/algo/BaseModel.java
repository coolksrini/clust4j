package com.clust4j.algo;

abstract public class BaseModel extends Clust4j implements java.io.Serializable {
	private static final long serialVersionUID = 4707757741169405063L;

	/** This should be synchronized and thread-safe */
	abstract BaseModel fit();
}