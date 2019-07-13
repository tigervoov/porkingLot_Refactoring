package com.thoughtworks.tdd.story_5;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SuperSmartParkingBoy {
    public String park(List<ParkingLot> parkingLotList, Car car) {
        if (car == null) {
            return "No car to park";
        } else {
            ParkingLot maxCapacityParkingLot = getMaxEmptyCapacityParkingLot(parkingLotList);

            if (maxCapacityParkingLot == null) {
                return "Not enough position.";
            }
            if (car.getPark() == true) {
                return "The car is parked.";
            } else {
                car.setPark(true);
                Ticket ticket = maxCapacityParkingLot.addTheCarToParkingLot(car.getCarNum());
                if (ticket != null) {
                    return "Park success.";
                } else {
                    return "Park failed.";
                }

            }
        }
    }
    public String superSmartPark(List<ParkingLot> parkingLotList, Car car){
        if (car == null) {
            return "No car to park";
        } if(car.getPark() == true){
            return "The car is parked.";
        }else{
            ParkingLot largerAvailableRateParkingLot = getLargerAvailableRatePakingLot(parkingLotList);

            if (largerAvailableRateParkingLot == null) {
                return "Not enough position.";
            }
            else {
                car.setPark(true);
                Ticket ticket = largerAvailableRateParkingLot.addTheCarToParkingLot(car.getCarNum());
                if (ticket != null) {
                    return "Park success.";
                } else {
                    return "Park failed.";
                }

            }
        }
    }
    public String fetchCar(ParkingLot parkingLot, Ticket ticket) {
        if (ticket == null) {
            return "Please provide your parking ticket.";
        } else {
            if (ticket.getValid()) {
                String carNum = ticket.getTicketNum();
                List<String> carNumList = parkingLot.getCarNumList();
                long existCarNum = carNumList.stream().filter(item -> item == carNum).collect(Collectors.counting());
                if (existCarNum > 0) {
                    return "Return your car.";
                } else {
                    return "Unrecognized parking ticket.";
                }
            }
            return "Unrecognized parking ticket.";
        }
    }

    public ParkingLot getMaxEmptyCapacityParkingLot(List<ParkingLot> parkingLotList) {
        List<ParkingLot> usefulParkingLotList = parkingLotList.stream()
                .filter(parkingLot -> parkingLot.getCapacity() != 0).collect(Collectors.toList());
        if (usefulParkingLotList.size() != 0) {
            List<Integer> capacityList = usefulParkingLotList.stream()
                    .map(item -> item.getCapacity()).collect(Collectors.toList());
            int maxCapacityParkLot = Collections.max(capacityList);
            int maxCapacityParkLotIndex = capacityList.indexOf(maxCapacityParkLot);
            ParkingLot maxCapacityParkingLot = usefulParkingLotList.get(maxCapacityParkLotIndex);
            return maxCapacityParkingLot;
        } else {
            return null;
        }
    }

    public ParkingLot getLargerAvailableRatePakingLot(List<ParkingLot> parkingLotList) {
        List<ParkingLot> usefulParkingLotList = parkingLotList.stream()
                .filter(parkingLot -> parkingLot.getCapacity() != 0).collect(Collectors.toList());
        if (usefulParkingLotList.size() != 0) {
            List<Double> availableRateList = usefulParkingLotList.stream()
                    .map(item -> (double) item.getEmptyCapacity() / (double) item.getCapacity()).collect(Collectors.toList());
            int LargerAvailableRateParkingLotIndex = availableRateList.indexOf(Collections.max(availableRateList));//找到最大使用率的停车场下标
            return usefulParkingLotList.get(LargerAvailableRateParkingLotIndex);
        } else {
            return null;
        }

    }

}
