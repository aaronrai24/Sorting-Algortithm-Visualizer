// Canvas variables
var canvas, canvaswidth, canvasheight, ctrl;

// Call canvasElements() to store height width
canvasElements();

// arr is for storing array element 
// itmd for storing intermediate values
// visited is for element which has been sorted
var arr = [],
    itmd = [],
    visited = []


// Length of unsorted array
var len_of_arr = 40;

// Store random values in arr
for (var i = 0; i < len_of_arr; i++) {
    arr.push(Math.round(Math.random() * 250))
}

// Initialize itmd and visited array with 0
for (var i = 0; i < len_of_arr; i++) {
    itmd.push(0)
    visited.push(0)
}

// Merging of two sub array
function mergeArray(start, end) {
    let mid = parseInt((start + end) >> 1);
    let start1 = start,
        start2 = mid + 1
    let end1 = mid,
        end2 = end

    // Initial index of merged subarray
    let index = start

    while (start1 <= end1 && start2 <= end2) {
        if (arr[start1] <= arr[start2]) {
            itmd[index] = arr[start1]
            index = index + 1
            start1 = start1 + 1;
        } else if (arr[start1] > arr[start2]) {
            itmd[index] = arr[start2]
            index = index + 1
            start2 = start2 + 1;
        }
    }

    // Copy the remaining elements of
    // arr[], if there are any
    while (start1 <= end1) {
        itmd[index] = arr[start1]
        index = index + 1
        start1 = start1 + 1;
    }

    while (start2 <= end2) {
        itmd[index] = arr[start2]
        index = index + 1
        start2 = start2 + 1;
    }

    index = start
    while (index <= end) {
        arr[index] = itmd[index];
        index++;
    }
}

// Function for showing visualization 
function drawBars(start, end) {

    // Clear pervious unsorted bars
    ctrl.clearRect(0, 0, 1000, 1500)

    // Styling of bars
    for (let i = 0; i < len_of_arr; i++) {

        ctrl.fillStyle = "#C5C7C9"
        ctrl.shadowOffsetX = 2
        ctrl.shadowColor = "black";
        ctrl.shadowBlur = 3;
        ctrl.shadowOffsetY = 5;


        ctrl.fillRect(25 * i, 300 - arr[i], 20, arr[i])

        if (visited[i]) {
            ctrl.fillStyle = "#F90101"
            ctrl.fillRect(25 * i, 300 - arr[i], 20, arr[i])
            ctrl.shadowOffsetX = 2
        }
    }

    for (let i = start; i <= end; i++) {
        ctrl.fillStyle = "#017DF9"
        ctrl.fillRect(25 * i, 300 - arr[i], 18, arr[i])
        ctrl.fillStyle = "#017DF9"
        ctrl.fillRect(25 * i, 300, 18, arr[i])
        visited[i] = 1
    }
}

// Waiting interval between two bars
function timeout(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}


// Merge Sorting
const mergeSort = async(start, end) => {
    if (start < end) {
        let mid = parseInt((start + end) >> 1)
        await mergeSort(start, mid)
        await mergeSort(mid + 1, end)
        await mergeArray(start, end)
        await drawBars(start, end)

        // Waiting time is 800ms
        await timeout(800)
    }
}

// canvasElements function for storing
// width and height in canvas variable
function canvasElements() {
    canvas = document.getElementById("Canvas")
    canvas.width = canvas.height = 1000
    canvaswidth = canvas.width
    canvasheight = canvas.height
    ctrl = canvas.getContext("2d")
}

//Merge Sort 
const performer = async() => {
    await mergeSort(0, len_of_arr - 1)
    await drawBars()

    //Change to array is sorted
    const title1_changer = document.querySelector(".title1")
    title1_changer.innerText = "Array is completely sorted"
}
performer()