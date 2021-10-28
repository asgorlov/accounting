import {Component, OnInit} from '@angular/core';
import {Transaction} from "./transaction";
import {TransactionService} from "./transaction.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  transactions: Transaction[];

  constructor(private transactionService: TransactionService) {
  }

  ngOnInit() {
    this.getTransactions();
  }

  public getTransactions(): void {
    this.transactionService.getTransactions().subscribe(
      (response: Transaction[]) => {
        this.transactions = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }
}
