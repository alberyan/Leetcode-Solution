class Solution {
    func maximumWealth(_ accounts: [[Int]]) -> Int {
        var maxWealth = 0
        for account in accounts {
            maxWealth = max(account.reduce(0, +), maxWealth)
        }
        return maxWealth
    }
}

// Runtime: 32 ms, faster than 87.50% of Swift online submissions for Richest Customer Wealth.
// Memory Usage: 14.2 MB, less than 27.98% of Swift online submissions for Richest Customer Wealth.