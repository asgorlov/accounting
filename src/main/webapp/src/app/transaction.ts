export interface Transaction {
  id: number;
  date: Date;
  type: string;
  value: number;
  comment: string;
  iconUrl: string;
}

export interface SearchFilter {
  date: Date;
  type: string;
}
