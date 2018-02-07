import java.util.Collections;
import java.util.Set;
import java.util.ArrayList;
import java.util.Observable;

import predictive.Dictionary;
import predictive.TreeDictionary;
import predictive.PredictivePrototype;

/**
 * This Model class contains the logic for a predictive text program.
 */
public class Model extends Observable {
	
	private Dictionary dictionary;
	private ArrayList<StringBuffer> texts;
	private StringBuffer signatureInput;
	private int prefixSelection;
	
	/**
	 * Constructor
	 * 
	 * @param path String path to the dictionary file
	 */
	public Model (String path) {
		super();
		this.dictionary = new TreeDictionary(path);
		this.texts = new ArrayList<StringBuffer>();
		this.signatureInput = new StringBuffer();
		this.prefixSelection = 0;
	}
	
	/**
	 * Getter for the Dictionary object
	 * 
	 * @return Dictionary object
	 */
	private Dictionary getDict () {
		return this.dictionary;
	}
	/**
	 * Getter for the typed texts
	 * 
	 * @return ArrayList containing the typed texts
	 */
	public ArrayList<StringBuffer> getTexts () {
		return this.texts;
	}
	/**
	 * Getter for the current signature input
	 * 
	 * @return StringBuffer for the current signature input
	 */
	public StringBuffer getSigInput () {
		return this.signatureInput;
	}
	/**
	 * Getter for the selection index if there's more than 1 word corresponding to the signature input
	 * 
	 * @return int selection index
	 */
	private int getSelection () {
		return this.prefixSelection;
	}
	
	/**
	 * Getter for the signature input, returns a string
	 * 
	 * @return String signature input
	 */
	private String getSigInputString () {
		return this.getSigInput().toString();
	}
	/**
	 * Getter for the set of words/prefixes corresponding to the current signature
	 * 
	 * @return Set of prefix strings
	 */
	private Set<String> getSetOfPrefixes () {
		return this.getDict().signatureToWords(this.getSigInputString());
	}
	/**
	 * Getter for the list of words/prefixes corresponding to the given signature
	 * 
	 * @param signature to look up
	 * @return list of prefix strings, sorted
	 */
	private ArrayList<String> getListOfPrefixes (String signature) {
		ArrayList<String> list = new ArrayList<String>();
		Set<String> set = this.getDict().signatureToWords(signature);
		for (String word : set) {
			list.add(word);
		}
		Collections.sort(list);
		return list;
	}
	/**
	 * Getter for the list of words/prefixes corresponding to the current signature
	 * 
	 * @return list of prefix strings, sorted
	 */
	public ArrayList<String> getListOfPrefixes () {
		return this.getListOfPrefixes(this.getSigInputString());
	}
	
	/**
	 * Setter for the current signature input
	 * 
	 * @param sig new signature
	 */
	private void setSigInput (String sig) {
		this.signatureInput = new StringBuffer(sig);
	}
	/**
	 * Setter for the selection
	 * 
	 * @param sel new int selection index
	 */
	private void setSelection (int sel) {
		this.prefixSelection = sel;
	}
	
	/**
	 * Reset the signature input to an empty string buffer
	 */
	private void resetSigInput () {
		this.signatureInput = new StringBuffer();
		this.resetSelection();
	}
	/**
	 * Reset the selection index to 0
	 */
	private void resetSelection () {
		this.prefixSelection = 0;
	}
	/**
	 * Determine whether the next sig is valid
	 * The next sig is valid when when combined with the current sig, there are at least 1 word in the dictionary
	 * corresponding to the resulting signature.
	 * 
	 * @param nextSignature the next signature to be combined with the current signature
	 * @return boolean stating whether the next signature is valid.
	 */
	private boolean nextSigIsValid (int nextSignature) {
		return ! this.getDict().signatureToWords(this.getSigInputString() + nextSignature).isEmpty();
	}
	/**
	 * Determine whether the prefix is a word inside the dictionary
	 * Uses TreeDictionary to check since it has all of the words inside the root
	 * 
	 * @param prefix string prefix
	 * @return boolean stating whether the prefix is a word
	 */
	private boolean isAWord (String prefix) {
		return ((TreeDictionary) this.getDict()).getWords().contains(prefix);
	}
	
	/**
	 * Helper for the observer pattern
	 */
	private void sendToObservers () {
		this.setChanged();
		this.notifyObservers();
	}
	
	
	/**
	 * Getter for the words we have typed so far, separated by a single space
	 * 
	 * @return string of typed words
	 */
	public String getTypedWords () {
		StringBuffer sb = new StringBuffer();
		for (StringBuffer word : this.getTexts()) {
			sb.append(word).append(" ");
		}
		return sb.toString();
	}
	/**
	 * Getter for the current words we are working on based on the current signature and the selection index
	 * 
	 * @return string of word we are working on
	 */
	public String getCurrentWord () {
		return this.getListOfPrefixes().get(this.getSelection());
	}
	/**
	 * Getter for the current signature
	 * 
	 * @return string of signature
	 */
	public String getCurrentSignature () {
		return this.getSigInputString();
	}
	
	/**
	 * Attempt to update the current signature input
	 * 
	 * @param signature int 2 to 9
	 */
	public void updateSignature (int signature) { // 2-9 
		if (this.nextSigIsValid(signature)) {
			this.getSigInput().append(signature);
			this.resetSelection();
			this.sendToObservers();
		}
		this.sendToObservers();
	}
	/**
	 * Cycle through the selection index
	 */
	public void cyclePrefixSelection () { // * 
		this.prefixSelection++;
		if (this.prefixSelection == this.getSetOfPrefixes().size()) {
			this.resetSelection();
		}
		this.sendToObservers();
	}
	/**
	 * Attempt to submit the word, will do nothing if the word we are working on is a strict prefix and not actually a word
	 */
	public void insertWord () { // 0 
		String p = this.getListOfPrefixes().get(this.getSelection());
		if (!this.isAWord(p)) {
			return;
		}
		this.getTexts().add(new StringBuffer(p));
		this.resetSigInput();
		this.sendToObservers();
	}
	/**
	 * Attempt to remove the last signature 
	 */
	public void removeLastSignature () { // # 
		if (this.getSigInput().length() > 0) {
			this.getSigInput().deleteCharAt(this.getSigInput().length() - 1);
			this.resetSelection();
			this.sendToObservers();
		} else if (this.getTexts().size() > 0) {
			StringBuffer sb = this.getTexts().remove(this.getTexts().size() - 1);
			this.setSigInput(PredictivePrototype.wordToSignature(sb.toString()));
			this.setSelection(this.getListOfPrefixes(this.getSigInputString()).indexOf(sb.toString()));
			this.sendToObservers();
		}
	}
	
}