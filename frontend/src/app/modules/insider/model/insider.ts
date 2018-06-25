import { InsiderAddress } from "./insider-address";
import { Company } from "../../company/model/company";
import { InsiderRelation } from "./insider-relation";

export class Insider {
    id: Number
    name: String
    address: InsiderAddress
    company: Company
    relation: InsiderRelation
}
