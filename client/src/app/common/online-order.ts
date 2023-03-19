import { Article } from "./article";
import { Base } from "./base";

export class OnlineOrder extends Base {

    id?: number;
    reference?: string;
    articles?: Article[];
    articleIds?: number[];

}
