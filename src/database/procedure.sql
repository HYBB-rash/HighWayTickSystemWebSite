-- 查询直达路线
drop procedure findRoute;
create procedure findRoute
    @Start varchar(30), @End varchar(30)
as
    begin
        declare @StartId int, @EndId int;
        select @StartId = id from IdAndNameInStation where name = @Start;
        select @EndId = id from IdAndNameInStation where name = @End;
        with t1 as (
            select TrainId
            from IdStationIdAndTrainIdInPass
            where StationId = @StartId
        ),
        t2 as (
            select TrainId
            from IdStationIdAndTrainIdInPass
            where StationId = @EndId
        ),
         t3 as (
             select t1.TrainId
             from t1 join t2 on t1.TrainId = t2.TrainId
        )
        select t3.TrainId id, train.TrainId, train.StartStation, train.EndStation, StartDate, EndDate, service
        from t3 join train on t3.TrainId = id;
    end
go

exec findRoute '北京西', '信阳东'
