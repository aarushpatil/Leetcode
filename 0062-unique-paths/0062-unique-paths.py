class Solution:
    def __init__(self):
        self.map = {}
        
    def uniquePaths(self, m, n):
        tot = m + n - 2
        denom = self.factorial(n - 1) * self.factorial(m - 1)
        return int(self.factorial(tot) / denom)

    def factorial(self, n):
        if n == 0:
            return 1
        if n in self.map:
            return self.map[n]
        sol = n * self.factorial(n - 1)
        self.map[n] = sol
        return sol
