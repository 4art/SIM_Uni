export class Config {
    private rest: String
    public getRest(): string {
        // return "http://rest.metraf.eu"
        // return "http://10.5.0.5:8080"
        return "http://167.99.246.230:8080"
    }
    private title: String
    public getTitle(): string {
        return "What is SIM?"
    }
    private text: String
    public getText(): string {
        return "SIM (short for Simple Insiders Monitoring)is a convenient, inexpensive and trusth-worthy information platform for stock market movement. This web-based app provides users with the most up-to-date stock transactions made by insiders of the biggest companies worldwide, which undeniably impact the status of world economy. For each company the sale table describes in details each stock trade in term of insider, date, type of transaction, the number of stocks, value etc. Hence, this tool would be helpful for users in accumulating information, analysing and making investment decisions.  "
    }
    private title2: String
    public getTitle2(): string {
        return "How to use?"
    }
    private text2: String
    public getText2(): string {
        return "With just a few simple steps: create an account, confirm email, sign it in and you are good to go."
    }
}
