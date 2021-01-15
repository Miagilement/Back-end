export class BaseResVO{
  constructor(
    private code:number,
    private message:String,
    public data:object
  ) {
  }
}
