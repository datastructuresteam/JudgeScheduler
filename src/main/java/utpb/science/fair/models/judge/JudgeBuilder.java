package main.java.utpb.science.fair.models.judge;

import main.java.utpb.science.fair.models.Builder;
import main.java.utpb.science.fair.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Creates an instance of type {@link Judge} from a non-<code>null</code>
 * {@link String} object.<br>
 * <br>
 * This builder makes 3 key assumptions:
 * <ol>
 * <li>The {@link String} object contains <em>only</em> one semicolon ":"</li>
 * <li>The Judge's full name is to the <em>left</em> of the semicolon</li>
 * <li>A comma seperated list of category names appear to the <em>right</em> of
 * the semicolon</li>
 * </ol>
 * <br>
 * <br>
 * <b>Example:</b> <blockquote>
 * <code>John Doe: Behavioral/Social Science, Chemistry, Earth/Space Science</code>
 * </blockquote>
 *
 */
public class JudgeBuilder implements Builder<Judge> {

	private final String _line;

	/**
	 * The line to parse.
	 * 
	 *
	 */
	public JudgeBuilder(String line) {
		_line = Objects.requireNonNull(line);
	}

	/**
	 * Creates a list tokens with everything to the left of the semicolon.
	 * 
	 * @return a {@link List} of {@link String} tokens
	 */
	private List<String> getNameTokens() {
		final int index = _line.indexOf(":");
		final String str = _line.substring(0, index);
		return StringUtil.tokenize(str);
	}

	/**
	 * Creates a list of tokens with everything to the right of the semicolon.
	 * 
	 * @return a {@link List} of {@link String} tokens
	 */
	private List<String> getCategoriesTokens() {
		final int index = _line.indexOf(":");
		final String str = _line.substring(index + 1, _line.length());
		return StringUtil.tokenize(str, ',');
	}

	/**
	 * Creates an instance of type {@link Judge} with the created Name and Category
	 * tokens. The list of categories that is associated with this judge are sorted
	 * in ascending order with the {@link String#CASE_INSENSITIVE_ORDER} comparator.
	 */
	@Override
	public Judge build() {
		final List<String> nameTokens = getNameTokens();
		final List<String> categoriesTokens = getCategoriesTokens();

		final String firstName = nameTokens.get(0);
		final String lastName = nameTokens.get(1);
		final List<String> categories = new ArrayList<>(categoriesTokens);
		Collections.sort(categories, String.CASE_INSENSITIVE_ORDER);

		return new Judge(firstName, lastName, categories);
	}

}
