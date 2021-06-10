package com.pinyin.converter;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinConverter {
	private HanyuPinyinOutputFormat pinyinFormat;
	
	public PinyinConverter() {
		this.pinyinFormat = new HanyuPinyinOutputFormat();
		this.pinyinFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		this.pinyinFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		this.pinyinFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
	}
	
	/**
	 * Convert Chinese string to pinyin
	 * @param zhText - Chinese string
	 * @return result - Pinyin converted from Chinese text
	 * @throws BadHanyuPinyinOutputFormatCombination
	 */
	@SuppressWarnings("deprecation")
	public String convertToPinyin(String zhText) {

	    String pinyin = null;
	    try {
	    	pinyin = PinyinHelper.toHanyuPinyinString(zhText, this.pinyinFormat, " ");
	    } catch (BadHanyuPinyinOutputFormatCombination e) {
	        return null;
	    }

	    return pinyin;
	}
}
