export class Car {
    private id!: string;
    private brand: string;
    private country: string;
    private createdAt: Date;
    private lastUpdated: Date;
    private registration: Date;

    constructor(brand: string, country: string, createdAt: Date, lastUpdated: Date, registration: Date){
        this.brand=brand;
        this.country=country;
        this.createdAt=createdAt;
        this.lastUpdated=lastUpdated;
        this.registration=registration;
    }
}
