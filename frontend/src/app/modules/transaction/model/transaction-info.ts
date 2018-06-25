import { TransactionType } from "./transaction-type";

export class TransactionInfo {
    security: String
    currency: String
    shares: Number
    price: Number
    valueUSD: Number
    holding: Number
    transactionType: TransactionType
    date: Date
}
