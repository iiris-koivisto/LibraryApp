export interface Book {
    book_id: bigint;
    name: string;
    author: string;
    publication_date: Date;
    publisher: string;
    genre: string;
    isLoaned: boolean;
}