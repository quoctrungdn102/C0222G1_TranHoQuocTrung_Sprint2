import {Customer} from './customer';
import {Product} from './product';

export interface Cart {
  id?: number;
  quality?: number;
  product?: Product;
  userCustomer?: string;
  statusDelete?: number;
}
