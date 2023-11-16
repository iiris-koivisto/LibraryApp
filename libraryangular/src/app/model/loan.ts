export interface Loan {
    loan_id: bigint;
    start_date: Date;
    end_date: Date;
    isReturned: boolean;
    employee_id: bigint;
    book_id: bigint;
    user_id: bigint;
    movie_id: bigint;
}