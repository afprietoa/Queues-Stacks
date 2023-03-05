import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		Stack<HtmlTag> tags2 = new Stack<>();

		while (!tags.isEmpty()){

			if(!tags.peek().isSelfClosing()){
				if(tags.peek().isOpenTag()){
					tags2.push(tags.remove());
				}else{
						if(tags2.isEmpty())
							return null;
						if(tags.peek().matches(tags2.peek())) {
							tags2.pop();
							tags.remove();
						}
						else
							return tags2;
					}

			}else{
				tags.remove();
			}
		}


		return tags2; // this line is here only so this code will compile if you don't modify it
	}
	

}

