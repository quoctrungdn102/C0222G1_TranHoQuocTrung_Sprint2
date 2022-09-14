import {Category} from './category';
import {Promotion} from './promotion';

export interface Product {
  id?: number;

  isDelete?: number;
  name?: string;
  cpu?: string;
  ram?: string;
  screenResolution?: string;
  releaseTime?: string;
  graphicCard?: string;
  price?: number;
  description?: string;
  image?: string;

  category?: Category;

  promotion?: Promotion;

}
