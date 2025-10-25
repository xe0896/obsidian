/*
 * @lc app=leetcode id=134 lang=javascript
 *
 * [134] Gas Station
 */

// @lc code=start
/**
 * @param {number[]} gas
 * @param {number[]} cost
 * @return {number}
 */
var canCompleteCircuit = function (gas, cost) {
	for (let i = 0; i < gas.length; i++) {
		let tank = gas[i];
		let stations = 0;
		// ptr = j + 1
		// Travel to (j + 1)th station: tank - cost[ptr] + gas[ptr]
		let j = i;
		while (true) {
			let next = (j + 1 + gas.length) % gas.length;
			tank -= cost[j];

			if (tank < 0) {
				break;
			}

			stations++;
			if (stations == gas.length) {
				return i;
			}
			tank += gas[next];
			j = next;
		}
	}

	return -1;
};
// @lc code=end
