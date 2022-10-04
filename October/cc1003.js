function countBoomerangs(arr) {
    if (arr.length < 3) return 0;
    let count = 0;
    for (let i = 0, j = 2; j < arr.length; i++, j++) {
        if (arr[i] === arr[j] && arr[i+1] !== arr[i])
            count++;
    }
    return count;
}

function oddishOrEvenish(n) {
    let digitSum = 0;
    while (n > 0) {
        digitSum += n % 10;
        n = Math.floor(n / 10);
    }
    return (digitSum % 2 == 0) ? "Evenish" : "Oddish";
}

console.log(countBoomerangs([9, 5, 9, 5, 1, 1, 1]));  // 2
console.log(countBoomerangs([5, 6, 6, 7, 6, 3, 9]));  // 1
console.log(countBoomerangs([4, 4, 4, 9, 9, 9, 9]));  // 0

console.log(oddishOrEvenish(43));   // "Oddish"
console.log(oddishOrEvenish(373));  // "Oddish"
console.log(oddishOrEvenish(4433)); // "Evenish"